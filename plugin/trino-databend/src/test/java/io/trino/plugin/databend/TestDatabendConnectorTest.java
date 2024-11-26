/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.plugin.databend;


import io.trino.testing.QueryRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDatabendConnectorTest
        extends BaseDatabendConnectorTest
{
    @Override
    protected QueryRunner createQueryRunner()
            throws Exception
    {
        databendServer = closeAfterClass(new TestingDatabendServer(TestingDatabendServer.DATABEND_DEFAULT_IMAGE));
        return DatabendQueryRunner.builder(databendServer)
                .addConnectorProperty("databend.connection-timeout", "60")
                .setInitialTables(REQUIRED_TPCH_TABLES)
                .build();
    }
}
