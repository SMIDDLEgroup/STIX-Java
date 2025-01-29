package stix.sdo

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import faker.StixMockDataGenerator
import io.digitalstate.stix.json.StixParsers
import io.digitalstate.stix.sdo.objects.Identity
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class IdentitySpec extends Specification {

    @Shared
    ObjectMapper mapper = new ObjectMapper()
    @Shared
    StixMockDataGenerator stixMockDataGenerator = new StixMockDataGenerator()

    @Unroll
    def "Generate Identity Data: Run: '#i'"() {
        when: "Generating Identity Data"
        Identity originalIdentity = stixMockDataGenerator.mockIdentity()
//            println "Original Object: ${originalIdentity.toString()}"

        then: "Convert Identity to Json"
        JsonNode originalJson = mapper.readTree(originalIdentity.toJsonString())
        String originalJsonString = mapper.writeValueAsString(originalJson)
//            println "Original Json: ${originalJsonString}"

        then: "Parse Json back into Attack Pattern Object"
        Identity parsedIdentity = (Identity) StixParsers.parseObject(originalJsonString)
        Identity parsedIdentityGeneric = StixParsers.parse(originalJsonString, Identity.class)
//            println "Parsed Object: ${parsedIdentity}"

        //@TODO needs to be setup to handle dehydrated object comparison
//        then: "Parsed object should match Original object"
//            assert originalAttackPattern == parsedAttackPattern

        then: "Convert Parsed Identity Object back to into Json"
        JsonNode newJson = mapper.readTree(parsedIdentity.toJsonString())
        String newJsonString = mapper.writeValueAsString(newJson)
//            println "New Json: ${newJsonString}"

        then: "New Json should match Original Json"
        JSONAssert.assertEquals(originalJsonString, newJsonString, JSONCompareMode.NON_EXTENSIBLE)

        where:
        i << (1..100)
    }
}
