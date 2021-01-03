package id.ac.ui.cs.mobileprogramming.movielore.manager

import android.content.Context
import android.content.Intent
import id.ac.ui.cs.mobileprogramming.movielore.data_model.FileToDownload
import id.ac.ui.cs.mobileprogramming.movielore.service.DownloadService
import java.util.ArrayList

class DownloadManager() {
    // file path is folder path
    // file name must be given with extension

    companion object {
        var indexToDownload: Int = 0
        var listOfFilesToBeDownloaded: ArrayList<FileToDownload?>? = ArrayList()
        var isNotificationShowing = false
        // calling start service again doesnot create new instance if service is already running

        fun initDownload(context: Context, fileUrl: String, filePath: String, fileName: String) {
            val fileToDownload = FileToDownload()
            fileToDownload.url = fileUrl
            fileToDownload.filePath = filePath
            fileToDownload.fileName = fileName
            fileToDownload.isDownloaded = false
            listOfFilesToBeDownloaded?.add(fileToDownload)
            if (listOfFilesToBeDownloaded?.size!! > 1) {
                isNotificationShowing = true
            }else{
                isNotificationShowing = false
            }
            val intent = Intent(context, DownloadService::class.java)
            context.startService(intent)
        }
    }
}