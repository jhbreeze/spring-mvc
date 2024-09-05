package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogTestController {

	@RequestMapping("/log-test")
	public String logTest() {
		String name = "Spring MVC";

		// 뒤로 갈수록 로그 레벨이 높아짐.
		// 설정정보 변경에 따라 로그 출력 범위를 제한할 수 있음. (개발용 ~debug / 운영계 info~)
		log.trace("trace log={}", name);
		log.debug("debug log={}", name);

		log.info(" info log={}", name);
		log.warn(" warn log={}", name);
		log.error("error log={}", name);

		return "ok";
	}

}
