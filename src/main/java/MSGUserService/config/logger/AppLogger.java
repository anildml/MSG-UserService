package MSGUserService.config.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class AppLogger {

    private Logger debugLogger = LoggerFactory.getLogger("debugger");

    public void debug(String message, Map<String, String> propertyMap) {
        ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request;
        if (attributes != null) {
            request = attributes.getRequest();
            String uuid = (String) request.getAttribute("uuid");
            MDC.put("uuid", uuid);
        }

        if (propertyMap != null) {
            StringBuilder prop = new StringBuilder();
            for (Map.Entry<String, String> entry : propertyMap.entrySet()) {
                prop
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("  ||  ");
            }
            message = message + "  ||  " + prop;
        }

        debugLogger.info(message);
        MDC.clear();
    }

}
