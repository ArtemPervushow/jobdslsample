package jobs

folder('my-maven-build-dsl-folder'){
    description('This is folder for gradle dsl job')
}

job('my-maven-build-dsl-folder/maven-from-dsl-job'){
    scm {
        git {
            remote {
                name('origin')
                url('https://github.com/LableOrg/java-maven-junit-helloworld.git')
                credentials('cacc3e70-7103-4613-b74b-eaa04c825483')
            }
            branch('master')
        }
    }
    logRotator {
        numToKeep(5)
        artifactNumToKeep(1)
    }
    triggers {
        scm('@daily')
    }
    steps {
        batchFile('echo We are maven!')
        maven {
            goals('clean')
            goals('package')
        }

    }
}