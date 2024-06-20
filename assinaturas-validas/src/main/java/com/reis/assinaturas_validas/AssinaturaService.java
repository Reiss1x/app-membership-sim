package com.reis.assinaturas_validas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.List;

@Service
public class AssinaturaService {

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String URL= "/servcad/asscod/{cod}";


    public Boolean validAssinatura(Long codAss){
        List<ServiceInstance> instances = discoveryClient.getInstances("cadastramento");
        if (instances != null && !instances.isEmpty()) {
            String site = URL.replace("{cod}", String.valueOf(codAss));
            String serviceUrl = instances.get(0).getUri().toString() + site;
            AssinaturaResponse assinatura = new RestTemplate().getForObject(serviceUrl, AssinaturaResponse.class);
            return Objects.equals(assinatura.status(), "ATIVA");
        }
        return null;
    }
}
