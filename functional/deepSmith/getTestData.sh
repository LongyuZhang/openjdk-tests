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


echo "get deepSmith test data sources..."
echo "initial $PWD"
mkdir -p data/src
cd data/src


# if [ "$env.JENKINS_PASSWORD" != "" ] && [ "$env.JENKINS_PASSWORD" != "" ]; then
#     curl_options="--user $env.JENKINS_USERNAME:$env.JENKINS_PASSWORD"
# fi

# tmp_data_link="https://na.artifactory.swg-devops.com:443/artifactory/sys-rt-generic-local/UploadFile/155/deepSmithData.tar.gz"
# echo "curl -OLJks --retry 5 --retry-delay 300 ${curl_options} ${tmp_data_link}"
# curl -OLJks --retry 5 --retry-delay 300 ${curl_options} ${tmp_data_link}

# file deepSmithData.tar.gz
# tar xvf deepSmithData.tar.gz
# mv jar_dir_name ../data
# cd ../
# echo "current directory is $PWD"
# rm -rf src

data_url=$DEEPSMITH_URL
# data_url=${env.DEEPSMITH_URL}
# curl_options="--user ${env.DEEPSMITH_USERNAME}:${env.DEEPSMITH_PASSWORD}"
echo "--user $DEEPSMITH_USERNAME:$DEEPSMITH_PASSWORD"
curl_options="--user $DEEPSMITH_USERNAME:$DEEPSMITH_PASSWORD"
echo "curl -OLJks --user ****:**** ${data_url}"
curl -OLJks ${curl_options} ${data_url}
file deepSmithData.tar.gz
# echo "current $PWD"

sources_file=`ls`
if [[ $sources_file == *zip || $sources_file == *jar ]]; then
    unzip -q $sources_file -d .
else
    gzip -cd $sources_file | tar xof -
fi
rm $sources_file
folder=`ls -d */`
mv $folder ../deepSmithData
cd ../
echo "finally $PWD"
rm -rf src
