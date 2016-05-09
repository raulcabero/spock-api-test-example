import groovy.json.JsonSlurper
import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import groovyx.net.http.ContentType


class RestSpecification extends Specification {

	
	RESTClient restClient = new RESTClient("https://todo.ly/")
	
	
	def setup() {
		restClient.auth.basic "sombrerodepaja@gmail.com", "Macross2"
	}
	
	

	def 'Chech getObject'() {

		when:
		def response = restClient.get(path:"api/projects.json")

		then:
		response.status == 200

		and:
		response.data.country == 'US2'
		response2.data[0].domain == 'open-test.ibmcloud.com'
		
	}
}