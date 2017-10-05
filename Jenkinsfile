node('docker-slave') {
  stage('Checkout'){
    checkout scm;
  }
  
  stage('Build Docker Image'){
    mvn clean package
  }
  
  stage('Deploy to registry'){
    
  }
}
