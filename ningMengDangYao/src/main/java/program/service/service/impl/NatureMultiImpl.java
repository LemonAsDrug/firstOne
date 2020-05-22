package program.service.service.impl;

import org.springframework.stereotype.Service;
import program.service.service.SeaMultiService;
import program.service.service.SkyMultiService;

@Service
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
