import groovyx.net.http.RESTClient
import spock.lang.Specification
import groovyx.net.http.ContentType

class UpdateProject extends Specification {

	RESTClient restClient = new RESTClient("https://todo.ly/")
	
	def setup() {
		restClient.setHeaders(
			"Authorization": "c29tYnJlcm9kZXBhamFAZ21haWwuY29tOk1hY3Jvc3My")
	}
	
	def "Update a project"() {

		given: 'given a projectId, and we update the content'
		def projectId = 3465350
		def newData = [Content: "newContent"]
		
		when: 'request to update project'
		def response = restClient.put(
			path:"api/projects/${projectId}.json",
			requestContentType: ContentType.JSON,  body: newData)

		then: 'the project #projectId has been updated'
		response.status == 200
		response.data.Content == newData.Content
		
	}
}