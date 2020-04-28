node {
    stage('SCM Checkout'){
        git 'https://github.com/Zerep34/api_hobeez'
    }
    stage('Compile-Package'){
        sh 'mvn clean install'
    }
}