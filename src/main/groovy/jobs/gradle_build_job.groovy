package jobs

folder('my-gradle-build-dsl-folder'){
    description('This is folder for gradle dsl job')
}

job('my-gradle-build-dsl-folder/gradle-from-dsl-job'){
    scm {
        git {
            remote {
                name('origin')
                url('https://github.com/ArtemPervushow/jobdslsample.git')
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
        batchFile('echo We are started!')
        gradle {
            tasks('clean')
            tasks('build')
        }
        conditionalSteps {
            condition {
                and {
                    status('SUCCESS', 'SUCCESS')
                } {
                    not {
                        fileExists('MyMain.class', BaseDir.ARTIFACTS_DIR)
                    }
                }
            }
            runner('master')
            steps {
                batchFile('echo we are starting tests')
                gradle {
                    tasks('testClasses')
                }
            }
        }
    }
}