buildMonitorView('AllJobsMonitor') {
    description('All jobs for project A')
    jobs {
        name('release-projectA')
        regex(/.+/)
    }
}