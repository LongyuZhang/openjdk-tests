#!/bin/sh
################################################################################
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
################################################################################

DEST="$1"
ARCH=`uname -m`

export MAVEN_OPTS="-Xmx1g"

cd $DEST
pwd

git clone https://github.com/quarkus-qe/quarkus-openshift-test-suite.git
cd quarkus-openshift-test-suite

echo "Compile and run quarkus_openshift tests"

if [[ $ARCH =~ "x86" ]]; then
    oc login --token=bgn5pEjb_1mnyDfAtj6hwOAfRL1WBpLXb6R-C8zsAdQ --server=https://api.digger.cp.fyre.ibm.com:6443 --insecure-skip-tls-verify
    ./mvnw -pl \!configmap/file-system,\!config-secret/file-system,\!microprofile,\!external-applications/todo-demo-app,\!deployment-strategies/quarkus clean verify -Dquarkus.s2i.base-jvm-image=docker.io/cosmoxiix/adopt11openj9px -Dversion.quarkus=1.7.2.Final -Dts.use-ephemeral-namespaces
elif [[ $ARCH =~ "s390x" ]]; then
    oc login --token=Q-3ovux3JxYmBxCBNqYy-Wg2wyC_u4fgS8_h5X8yUMg --server=https://api.slimy.cp.fyre.ibm.com:6443 --insecure-skip-tls-verify
    ./mvnw -pl \!configmap/file-system,\!config-secret/file-system,\!messaging/artemis,\!messaging/artemis-jta,\!messaging/amqp-reactive,\!messaging/qpid,\!sql-db/postgresql,\!sql-db/mssql,\!security/keycloak,\!security/keycloak-authz,\!microprofile,\!external-applications/todo-demo-app,\!deployment-strategies/quarkus clean verify -Dquarkus.s2i.base-jvm-image=docker.io/cosmoxiix/adopt11openj9s390x -Dversion.quarkus=1.7.2.Final -Dts.use-ephemeral-namespaces
elif [[ $ARCH =~ "ppc64le" ]]; then
    oc login --token=XDFAomeetJyZXlJVgWRxlZX2QsFGIVTfmvFGwQricSE --server=https://api.ocple.cp.fyre.ibm.com:6443 --insecure-skip-tls-verify
    ./mvnw -pl \!configmap/file-system,\!config-secret/file-system,\!messaging/artemis,\!messaging/artemis-jta,\!messaging/amqp-reactive,\!messaging/qpid,\!sql-db/mssql,\!security/keycloak,\!security/keycloak-authz,\!microprofile,\!deployment-strategies/quarkus clean verify -Dquarkus.s2i.base-jvm-image=docker.io/cosmoxiix/adopt11openj9px -Dversion.quarkus=1.7.2.Final -Dts.use-ephemeral-namespaces
else
    echo "This arch is no supported."
    exit 1
fi
test_exit_code=$?
echo "Build quarkus_openshift completed"
exit $test_exit_code
