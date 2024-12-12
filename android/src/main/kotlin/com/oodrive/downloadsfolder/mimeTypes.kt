package com.oodrive.downloadsfolder

import android.webkit.MimeTypeMap


/**
 * Gets the MIME type of a file based on its extension.
 *
 * @param extension The file extension (e.g., "pdf", "jpg").
 * @return The MIME type of the file, or null if the extension is not recognized.
 */
fun getMimeTypeFromExtension(extension: String?): String? {
    return if (extension != null) {
        // Check if the extension is not null.

        // Use MimeTypeMap to get the MIME type based on the extension.
        // Convert the extension to lowercase and remove any leading dots.
        val lowercasedExtension = extension.lowercase().replace(".", "")
        val mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowercasedExtension)

        // If the MIME type is found, return it. Otherwise, use a custom mapping.
        mimeType ?: mimeTypes[lowercasedExtension]
    } else {
        // If the extension is null, return null.
        null
    }
}


// Define a custom mapping of extensions to MIME types for cases where MimeTypeMap.getSingleton() doesn't provide a match.
private val mimeTypes = mapOf(
    "pdf" to "application/pdf",
    "xlsx" to "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    "txt" to "text/plain",
    "fly" to "text/vnd.fly"
)