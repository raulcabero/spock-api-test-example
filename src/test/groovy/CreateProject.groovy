import groovy.json.JsonSlurper
import groovyx.net.http.RESTClient
import spock.lang.Specification
import spock.lang.Unroll
import groovyx.net.http.ContentType

class CreateProject extends Specification {

	RESTClient restClient = new RESTClient("https://todo.ly/")
	JsonSlurper jsonSlurper = new JsonSlurper()
	
	def setup() {
		restClient.setHeaders(
			"Authorization": "c29tYnJlcm9kZXBhamFAZ21haWwuY29tOk1hY3Jvc3My")
	}
	
	@Unroll("Check create project for this input #json")
	def "Get a project"() {

		given: 'given the project data'
		def object = jsonSlurper.parseText(json)
		
		when: 'request to create project'
		def response = restClient.post(
			path: "api/projects.json",
			requestContentType: ContentType.JSON,  body: object)

		then:
		response.status == 200
		response.data.Content == object.Content
		response.data.Icon == object.Icon
		
		where: 'data driven of jsons'
		json | _
		'{"Content": "My Project 1", "Icon": 4}' | _
		'{"Content": "My Project 2", "Icon": 4}' | _
		
	}
}
