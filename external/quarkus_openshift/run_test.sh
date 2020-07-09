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

# OS=`uname`
# LOC=`locale charmap`
# FULLLANG=${OS}_${LANG%.*}.${LOC}

# BASE=`dirname $0`
# export BASE
# . ${BASE}/set_variable.sh
# CP="-cp ${BASE}/codepoint.jar"

# ${JAVA_BIN}/java ${CP} UnicodeDataTest 2> err.txt
# ${JAVA_BIN}/java ${CP} UnihanCodePoint 2>>err.txt

# if [ -s err.txt ]; then
#   echo Test Failed
#   exit 1
# else
#   echo Test Passed
#   exit 0
# fi


DEST="$1"


export MAVEN_OPTS="-Xmx1g"

cd $DEST
pwd
git clone https://github.com/quarkus-qe/quarkus-openshift-test-suite.git
cd quarkus-openshift-test-suite
pwd
echo "Compile and run quarkus_openshift tests"
oc login --token=DcPtiZMxFjSBJ4G58DbGSX32L3C2tzUWtMdxWig4XCI --server=https://api.seeped.cp.fyre.ibm.com:6443 --insecure-skip-tls-verify
oc whoami
oc project
# mvn -pl clean verify -Dversion.quarkus=1.3.2.Final -Dts.use-ephemeral-namespaces 
./mvnw clean verify -Dtest=!ScalingOpenShiftIT -Dversion.quarkus=1.3.0.Final -Dts.use-ephemeral-namespaces
test_exit_code=$?
echo "Build quarkus_openshift completed"

# find ./ -type d -name 'surefire-reports' -exec cp -r "{}" /testResults \;
# echo "Test results copied"

exit $test_exit_code
