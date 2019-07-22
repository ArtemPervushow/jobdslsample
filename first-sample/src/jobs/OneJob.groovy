folder('first') {
    description 'First script'
}

job("first/gradle-example-build") {
    scm {
        github repo
    }
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        echo 'hello world'
    }
}