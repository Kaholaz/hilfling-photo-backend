package no.fg.hilflingbackend.blobStorage

import com.azure.storage.blob.BlobServiceClient
import com.azure.storage.blob.BlobServiceClientBuilder
import com.azure.storage.blob.models.BlobHttpHeaders
import com.azure.storage.blob.models.BlobStorageException
import no.fg.hilflingbackend.value_object.ImageFileName
import org.springframework.stereotype.Repository
import org.springframework.web.multipart.MultipartFile
import java.security.InvalidParameterException

@Repository
class AzureBlobStorage(val azureStorageConfiguration: AzureStorageConfiguration) : IAzureBlobStorage {

  val blobServiceClient: BlobServiceClient = BlobServiceClientBuilder()
    .connectionString(azureStorageConfiguration.azureStorageConnectionString)
    .buildClient()

  override fun saveFile(multipartFile: MultipartFile, blobContainerName: String, fileName: ImageFileName): String {
    // Have to get a blob container client
    try {
      val blobContainerClient = this.blobServiceClient.getBlobContainerClient(blobContainerName)

      // Create blob client
      val blobClient = blobContainerClient.getBlobClient(fileName.filename)
      // Upload file
      blobClient.upload(multipartFile.inputStream, multipartFile.size,)
      // Specify http headers to tell blob storage it is a image
      val contentType = BlobHttpHeaders().setContentType(multipartFile.contentType)
      blobClient.setHttpHeaders(contentType)

      return blobClient.blobUrl
    } catch (e: BlobStorageException) {
      // Handle exception
      throw InvalidParameterException("Blob container $blobContainerName does not exist")
    }
  }

  override fun deleteFile(blobContainerName: String, fileName: ImageFileName): Boolean {
    return try {
      val blobServiceClient = this.blobServiceClient.getBlobContainerClient(blobContainerName)
      blobServiceClient.getBlobClient(fileName.filename).delete()
      true
    } catch (e: BlobStorageException) {
      false
    }
  }
}
