package com.busycoder.resilency.serviceproxy;

import com.busycoder.resilency.dto.LoanDto;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceFallBack implements LoanServiceProxy{
    @Override
    public LoanDto findByMobileNumber(String mobile) {
        //we can not return any fallback response here as loan service can not faked
        return null;
    }
}
