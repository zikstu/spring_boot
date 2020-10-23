pipeline {
   agent any

   stages {
      stage('拉取代码') {
         steps {
           checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '6bd876ad-5a62-4208-93e8-f72c1464ee8a', url: 'https://github.com/kanggeaiphp/spring_boot.git']]])
         }
      }

      stage('编译打包') {
         steps {
             sh label: '', script: 'mvn clean package'
         }
      }
      stage('项目部署') {
         steps {
             sh label: '', script: 'nohup java -server -Xms256m -Xmx256m -jar -Dserver.port=8092 -Dspring.profils.active=dev pdf-0.0.1-SNAPSHOT.jar > pdf.log 2>&1 &'
         }
      }

   }
}