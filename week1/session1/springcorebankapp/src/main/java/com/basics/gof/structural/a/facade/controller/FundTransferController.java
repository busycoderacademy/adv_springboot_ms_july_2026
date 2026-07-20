//package com.basics.gof.structural.a.facade.controller;
//
//import com.basics.gof.structural.a.facade.facade.FundTransferFacade;
//
//@RestController
//@RequestMapping("/transfer")
//public class FundTransferController {
//    private final FundTransferFacade fundTransferFacade;
//
//    public FundTransferController(FundTransferFacade fundTransferFacade) {
//        this.fundTransferFacade = fundTransferFacade;
//    }
//
//    @PostMapping
//    public String transfer(@RequestParam String from,
//                           @RequestParam String to,
//                           @RequestParam double amount) {
//        fundTransferFacade.transferFunds(from, to, amount);
//        return "Transfer initiated.";
//    }
//}