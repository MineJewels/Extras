package org.minejewels.jewelsextras.announcement;

import net.abyssdev.abysslib.patterns.service.impl.DefaultService;
import net.abyssdev.abysslib.patterns.service.type.ServiceType;

import java.util.List;

public class AnnounceService extends DefaultService<List<String>> {
    public AnnounceService() {
        super(ServiceType.LIST);
    }
}
