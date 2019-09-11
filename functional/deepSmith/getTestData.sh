#!/bin/bash
#
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


echo "get test data sources..."
mkdir -p data/src
cd data/src
if [ "$env.JENKINS_PASSWORD" != "" ] && [ "$env.JENKINS_PASSWORD" != "" ]; then
    curl_options="--user $env.JENKINS_USERNAME:$env.JENKINS_PASSWORD"
fi

tmp_data_link="https://na.artifactory.swg-devops.com/artifactory/sys-rt-generic-local/hyc-runtimes-jenkins.swg-devops.com/Build_JDK8_x86-64_linux_Nightly/144/OpenJ9-JDK8-x86-64_linux-20190910-182412.tar.gz"
echo "curl -OLJks --retry 5 --retry-delay 300 ${curl_options} ${tmp_data_link}"
curl -OLJks --retry 5 --retry-delay 300 ${curl_options} ${tmp_data_link}

sources_file=`ls`
if [[ $sources_file == *zip || $sources_file == *jar ]]; then
    unzip -q $sources_file -d .
else
    gzip -cd $sources_file | tar xof -
fi
rm $sources_file
folder=`ls -d */`
mv $folder ../data
cd ../
echo "current directory is $PWD"
rm -rf src
