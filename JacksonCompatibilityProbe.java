import org.testcontainers.shaded.com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.api.model.Info;
public class JacksonCompatibilityProbe {
 public static void main(String[] args) throws Exception {
  Info info = DockerClientConfig.getDefaultObjectMapper().readValue("{\"ID\":\"docker-id\",\"Containers\":3,\"DockerRootDir\":\"/var/lib/docker\"}", Info.class);
  if (!"docker-id".equals(info.getId()) || info.getContainers() != 3 || !"/var/lib/docker".equals(info.getDockerRootDir())) throw new AssertionError("Docker response fields not mapped: "+info);
  System.out.println("Docker info deserialization passed");
 }
}