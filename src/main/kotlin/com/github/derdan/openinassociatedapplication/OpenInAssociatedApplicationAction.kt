package com.github.derdan.openinassociatedapplication

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileTypes.NativeFileType

class OpenInAssociatedApplicationAction : AnAction() {
    override fun update(e: AnActionEvent) {
        super.update(e)
    }

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val selectedFiles = anActionEvent.getData(CommonDataKeys.VIRTUAL_FILE_ARRAY) ?: return
        if (selectedFiles.size < MAXIMAL_FILES) {
            for (file in selectedFiles)
                NativeFileType.openAssociatedApplication(file)
        }
    }

    companion object {
        const val MAXIMAL_FILES = 10
    }
}
