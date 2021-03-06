folder('my-gradle-build-dsl-folder'){
    description('This is folder for gradle dsl job')
}

job('gradle-from-dsl-job'){
    scm {
        remote {
            name('origin')
            url('https://github.com/ArtemPervushow/jobdslsample.git')
            credentials('cacc3e70-7103-4613-b74b-eaa04c825483')
        }
        branch('master')
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