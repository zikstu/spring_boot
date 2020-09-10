pipeline {
   agent any

   stages {
      stage('拉取代码') {
         steps {
           checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '507bcd6f-c8ea-4943-afdf-85915cc474d0', url: 'git@github.com:kanggeaiphp/spring_boot.git']]])
         }
      }

      stage('编译打包') {
         steps {
             sh label: '', script: 'mvn clean package'
         }
      }
      stage('项目部署') {
         steps {
             deploy adapters: [tomcat8(credentialsId: '1ef92d74-e676-457d-87fb-eac48161f91b', path: '', url: 'http://47.110.91.150:8080/')], contextPath: null, war: 'target/*.war'
         }
      }

   }
}