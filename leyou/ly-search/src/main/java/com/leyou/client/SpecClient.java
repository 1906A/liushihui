package com.leyou.client;



import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "item-service")
public interface SpecClient extends SpecClient1{


}
