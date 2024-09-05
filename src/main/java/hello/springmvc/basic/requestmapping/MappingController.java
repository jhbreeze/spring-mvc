package hello.springmvc.basic.requestmapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {

	@RequestMapping // Http 메서드를 지정하지 않으면 모두 허용(GET, POST, PUT, PATCH, DELETE, HEAD)
	public String helloBasic() {
		log.info("helloBasic");
		return "ok";
	}

	@GetMapping
	public String mappingGetV2() {
		log.info("mappingGetV2");
		return "ok";
	}

	/*
	PathVariable(경로 변수) 사용
	 */
	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable String userId) {
		log.info("mappingPath userId = {} ",  userId);
		return "ok";
	}

	/*
	특정 헤더 조건 매핑
		* headers="mode",
		* headers="!mode"
		* headers="mode=debug"
		* headers="mode!=debug" (! = )
	 */
	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
		log.info("mappingHeader");
		return "ok";
	}

	// 마디어 타입에 따른 매핑 //////////////////////////////////////////////////

	/*
	Content-Type 헤더 기반 추가 매핑 Media Type
		* consumes="application/json"
		* consumes="!application/json"
		* consumes="application/*"
		* consumes="*\/*"
		* MediaType.APPLICATION_JSON_VALUE
	 */
	@PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String mappingConsume() {
		log.info("mappingConsume");
		return "ok";
	}

	/*
	Accept 헤더 기반 Media Type
		* produces = "text/html"
		* produces = "!text/html"
		* produces = "text/*"
		* produces = "*\/*"
	 */
	@PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
	public String mappingProduces() {
		log.info("mappingProduces");
		return "ok";
	}

}
