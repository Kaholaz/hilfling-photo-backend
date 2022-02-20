package no.fg.hilflingbackend.integrationTests

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest()
@AutoConfigureMockMvc
class PhotoControllerIntegrationTests {

  @Autowired
  lateinit var mvc: MockMvc

  @Test
  fun `should return a list of photos`() {
    mvc.get("/photos/")
      .andExpect { status { isOk() } }
  }

  @Test
  fun `should create photo`() {
    val postRequest = "/photos/upload?isGoodPhotoList=true&motiveTitle=Carohh&placeName=Klubben&securityLevelId=8314142f-7c08-48ad-9130-fd7ac6b23e52&eventOwnerName=UKA&photoGangBangerId=6a89444f-25f6-44d9-8a73-94587d72b839&albumId=8a2bb663-1260-4c16-933c-a2af7420f5ff&categoryIdList=2832ee5e-3f11-4f11-8189-56ca4f70f418&tagList=caro&placeIdList=9f4fa5d6-ad7c-419c-be58-1ee73f212675&categoryName=Gjengfoto"
    // TODO: Make upload file test work
    /*
    mvc.perform(fileUpload(postRequest).file(MockMultipartFile("file", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "test".toByteArray())))
      .andExpect(status().isOk)
    mvc.perform(MockMvcRequestBuilders.multipart(postRequest).file(MockMultipartFile("file", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "test".toByteArray())))
      .andExpect(status().isOk)
     */
  }
}
