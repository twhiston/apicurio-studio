/*
 * Copyright 2017 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.hub.api.github;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eric.wittmann@gmail.com
 */
public class GitHubResourceResolverTest {

    /**
     * Test method for {@link io.apicurio.hub.api.github.GitHubResourceResolver#resolve(java.lang.String)}.
     */
    @Test
    public void testResolve() {
        GitHubResource resource = GitHubResourceResolver.resolve("https://github.com/Apicurio/api-samples/blob/master/pet-store/pet-store.json");
        Assert.assertNotNull(resource);
        Assert.assertEquals("Apicurio", resource.getOrganization());
        Assert.assertEquals("api-samples", resource.getRepository());
        Assert.assertEquals("pet-store/pet-store.json", resource.getResourcePath());

        resource = GitHubResourceResolver.resolve("https://github.com/Apicurio/api-samples/blob/master/apiman-rls/sub1/sub2/apiman-rls.json");
        Assert.assertNotNull(resource);
        Assert.assertEquals("Apicurio", resource.getOrganization());
        Assert.assertEquals("api-samples", resource.getRepository());
        Assert.assertEquals("apiman-rls/sub1/sub2/apiman-rls.json", resource.getResourcePath());

        resource = GitHubResourceResolver.resolve("https://raw.githubusercontent.com/Apicurio/api-samples/master/apiman-rls/apiman-rls.json");
        Assert.assertNotNull(resource);
        Assert.assertEquals("Apicurio", resource.getOrganization());
        Assert.assertEquals("api-samples", resource.getRepository());
        Assert.assertEquals("apiman-rls/apiman-rls.json", resource.getResourcePath());

        resource = GitHubResourceResolver.resolve("https://github.com/Apicurio/api-samples/blob/master/pet-store.json");
        Assert.assertNotNull(resource);
        Assert.assertEquals("Apicurio", resource.getOrganization());
        Assert.assertEquals("api-samples", resource.getRepository());
        Assert.assertEquals("pet-store.json", resource.getResourcePath());
    }

}
