folder('my-gradle-build-dsl-folder'){
    description('This is folder for gradle dsl job')
}

job('gradle-from-dsl-job'){
    scm {
        github repo
    }
    logRotator {
        numToKeep(5)
        artifactNumToKeep(1)
    }
    triggers {
        scm('@daily')
    }
    steps {
        batchFile('echo We are started!')
        gradle {
            tasks('clean')
            tasks('build')
        }
    }
}