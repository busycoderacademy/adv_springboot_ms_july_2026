package com.busycoder.resilency.serviceproxy;

import com.busycoder.resilency.dto.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "card-service", url = "http://localhost:8090")
@FeignClient(name = "LOANS", fallback = LoanServiceFallBack.class)
public interface LoanServiceProxy {
    @GetMapping(path = "api/fetch")
    public LoanDto findByMobileNumber(@RequestParam(name="mobile") String mobile);
}
