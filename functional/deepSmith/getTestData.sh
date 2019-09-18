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
mkdir -p data/src
cd data/src
curl_options="--user $DEEPSMITH_USERNAME:$DEEPSMITH_PASSWORD"
echo "curl -OLJks --user ****:**** $DEEPSMITH_URL"
curl -OLJks ${curl_options} $DEEPSMITH_URL
file deepSmithData.tar.gz
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
rm -rf src
