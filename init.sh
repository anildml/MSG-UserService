#!/bin/bash

echo "VAULT_KEY_BASE64"
KEY="$( stty -echo; head -n 1; stty echo )"

echo "VAULT_URL"
VAULT_URL="$( stty -echo; head -n 1; stty echo )"

echo "VAULT_ADMIN_PW"
VAULT_ADMIN_PW="$( stty -echo; head -n 1; stty echo )"

echo "DB_URL"
DB_URL="$( stty -echo; head -n 1; stty echo )"


TOKEN=""
SU=""
SUP=""

unseal_vault()
{
  UNSEAL_RES=$(curl -X POST $VAULT_URL'/sys/unseal' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "key": "'$KEY'"
  }')
}

seal_vault()
{
  SEAL_RES=$(curl --location --request POST $VAULT_URL'/sys/seal' \
  --header 'Content-Type: application/json')
}

login_vault()
{
  LOGIN_RES=$(curl --location --request POST $VAULT_URL'/auth/userpass/login/admin' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  	"password": "'$VAULT_ADMIN_PW'"
  }')

  TOKEN=$(echo $LOGIN_RES | jq ".auth.client_token")

  TOKEN="${TOKEN%\"}"
  TOKEN="${TOKEN#\"}"
}

get_su()
{
  SU_RES=$(curl --location --request GET $VAULT_URL'/hakki/data/msg/userservice/db/su' \
  --header 'X-Vault-Token: '$TOKEN)

  SU=$(echo $SU_RES | jq ".data.data.value")

  SU="${SU%\"}"
  SU="${SU#\"}"
}

get_sup()
{
  SUP_RES=$(curl --location --request GET $VAULT_URL'/hakki/data/msg/userservice/db/sup' \
  --header 'X-Vault-Token: '$TOKEN)

  SUP=$(echo $SUP_RES | jq ".data.data.value")

  SUP="${SUP%\"}"
  SUP="${SUP#\"}"
}

unseal_vault
login_vault
get_su
get_sup
seal_vault

java -jar ./target/msg-user-service.jar \
--spring.datasource.url=jdbc:mariadb://$DB_URL \
--spring.datasource.username=$SU \
--spring.datasource.password=$SUP
