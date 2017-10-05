node('docker-slave') {
  stage('Checkout'){
    checkout scm;
  }
  
  stage('Build Docker Image'){
    sh '''
    mvn clean package
   '''
  }
  
  stage('Deploy to registry'){
    
  }
}
