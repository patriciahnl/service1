node('docker-slave') {
  stage('Checkout'){
    checkout scm;
  }
  
  stage('Build Docker Image'){
    sh '''
    mvn clean package docker:build -Pciserver
   '''
  }
  
  stage('Deploy to registry'){
     sh '''
    mvn clean package docker:push -Pciserver
   '''   
  }
}
