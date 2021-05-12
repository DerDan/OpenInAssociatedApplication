package com.github.derdan.openinassociatedapplication.services

import com.github.derdan.openinassociatedapplication.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
