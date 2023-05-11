package com.github.derdan.openinassociatedapplication

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileTypes.NativeFileType
import com.intellij.openapi.project.DumbAware
import javax.swing.JOptionPane

class OpenInAssociatedApplicationAction : AnAction(), DumbAware {

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val selectedFiles = anActionEvent.getData(CommonDataKeys.VIRTUAL_FILE_ARRAY) ?: return
        val notOpend: MutableList<String> = mutableListOf()
        if (selectedFiles.size < MAXIMAL_FILES) {
            for (file in selectedFiles)
                if (file.isInLocalFileSystem) {
                    NativeFileType.openAssociatedApplication(file)
                } else {
                    notOpend.add(file.presentableName)
                }
            if (notOpend.isNotEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "file(s) could not be opened:\n${notOpend.joinToString(separator = "\n")}",
                    "open in associated application",
                    JOptionPane.ERROR_MESSAGE
                )
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                "to many files selected", "open in associated application", JOptionPane.ERROR_MESSAGE
            )

        }
    }

    companion object {
        const val MAXIMAL_FILES = 10
    }
}
