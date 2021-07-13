import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.VersionRange;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VersionRangeTest {

    @Test
    void range_with_single_version_should_contain_that_version() throws Exception {
        VersionRange range_1_0_0 = VersionRange.createFromVersionSpec("[1.0.0]");
        ArtifactVersion version_1_0_0 = new DefaultArtifactVersion("1.0.0");

        assertThat(range_1_0_0.containsVersion(version_1_0_0)).isTrue();
    }

    @Test
    void range_with_single_version_should_not_contain_another_version() throws Exception {
        VersionRange range_1_0_0 = VersionRange.createFromVersionSpec("[1.0.0]");
        ArtifactVersion version_2_0_0 = new DefaultArtifactVersion("2.0.0");

        assertThat(range_1_0_0.containsVersion(version_2_0_0)).isFalse();
    }
}
