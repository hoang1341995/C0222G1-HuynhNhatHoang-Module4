package example.service.impl;

import example.service.IChangeService;
import org.springframework.stereotype.Service;

@Service
public class ChangeService implements IChangeService {

    @Override
    public int returnResult(int usd) {
        return usd*23000;
    }
}
