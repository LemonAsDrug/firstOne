package program.utils_other.service.impl;

import program.utils_other.service.SeaMultiService;
import program.utils_other.service.SkyMultiService;



public class NatureMultiImpl implements SeaMultiService, SkyMultiService {
    @Override
    public String getFish() {
        return "海里很多很多的鱼";
    }

    @Override
    public String getCloud() {
        return "天上有很多很多的云";
    }
}
