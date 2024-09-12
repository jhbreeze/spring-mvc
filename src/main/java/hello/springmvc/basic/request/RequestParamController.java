package hello.springmvc.basic.request;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {

	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		log.info("username = {}, age = {}", username, age);

		response.getWriter().write("ok");

	}

	@ResponseBody // view 조회 무시하고, HTTP message body에 직접 내용 입력
	@RequestMapping("/request-param-v2")
	public String requestParamV2(@RequestParam("memberName") String username, @RequestParam("age") int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParamV3(@RequestParam String username, @RequestParam int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(String username, int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}
}
