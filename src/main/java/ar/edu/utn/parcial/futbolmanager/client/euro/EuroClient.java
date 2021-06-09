package ar.edu.utn.parcial.futbolmanager.client.euro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "Players", url = "${api.euro.url}")// --> en properties api.euro.url="url"
public interface EuroClient {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<EuroResponse> getEuroEnchages();

}
