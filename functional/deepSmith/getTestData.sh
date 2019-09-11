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

tmp_data_link="https://na.artifactory.swg-devops.com:443/artifactory/sys-rt-generic-local/UploadFile/155/deepSmithData.tar.gz"
echo "curl -OLJks --retry 5 --retry-delay 300 ${curl_options} ${tmp_data_link}"
curl -OLJks --retry 5 --retry-delay 300 ${curl_options} ${tmp_data_link}

file deepSmithData.tar.gz
tar xvf deepSmithData.tar.gz
mv jar_dir_name ../data

# jar_files=`ls`
# jar_file_array=(${jar_files//\\n/ })
# for jar_name in "${jar_file_array[@]}"
#     do
#         echo "unzip file: $jar_name ..."
#         if [[ $jar_name == *zip || $jar_name == *jar ]]; then
#             unzip -q $jar_name -d .
#         else
#             gzip -cd $jar_name | tar xof -
#         fi
#     done

# jar_dirs=`ls -d */`
# jar_dir_array=(${jar_dirs//\\n/ })
# for jar_dir in "${jar_dir_array[@]}"
#     do
#         jar_dir_name=${jar_dir%?}
#         mv jar_dir_name ../data
#         # if [[ "$jar_dir_name" =~ jre*  &&  "$jar_dir_name" != "j2re-image" ]]; then
#         #     if [[ -d $jar_dir_name/Contents/Home ]]; then
#         #         mv "$jar_dir_name/Contents/Home" j2re-image
#         #     else
#         #         mv $jar_dir_name j2re-image
#         #     fi
#         # elif [[ "$jar_dir_name" =~ jdk*  &&  "$jar_dir_name" != "j2sdk-image" ]]; then
#         #     if [[ -d $jar_dir_name/Contents/Home ]]; then
#         #         mv "$jar_dir_name/Contents/Home" j2sdk-image
#         #     else
#         #         mv $jar_dir_name j2sdk-image
#         #     fi
#         # # if native test libs folder is available, mv it under native-test-libs
#         # elif [[ "$jar_dir_name"  =~ native-test-libs*  &&  "$jar_dir_name" != "native-test-libs" ]]; then
#         #     mv $jar_dir_name native-test-libs
#         # #The following only needed if openj9 has a different image name convention
#         # elif [[ "$jar_dir_name" != "j2sdk-image"  &&  "$jar_dir_name" != "native-test-libs" ]]; then
#         #     mv $jar_dir_name j2sdk-image
#         # fi
#     done
# # chmod -R 755 j2sdk-image


# sources_file=`ls`
# if [[ $sources_file == *zip || $sources_file == *jar ]]; then
#     unzip -q $sources_file -d .
# else
#     gzip -cd $sources_file | tar xof -
# fi
# rm $sources_file
# folder=`ls -d */`
# mv $folder ../data
cd ../
echo "current directory is $PWD"
rm -rf src
