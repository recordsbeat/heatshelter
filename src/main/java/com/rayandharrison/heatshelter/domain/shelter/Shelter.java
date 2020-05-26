package com.rayandharrison.heatshelter.domain.shelter;

import com.rayandharrison.heatshelter.vo.enums.YesOrNo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash("shelter")
public class Shelter implements Serializable {

    @Id
    private String shltrNm;
    private String legaldongNm;
    private Integer aceptncPosblCo;
    private Integer fanHoldCo;
    private Integer arcndtnHoldCo;
    private YesOrNo nightExtnYn;
    private YesOrNo wkendUseYn;
    private YesOrNo stayngYn;
    private String rdnmadr;
    private String lnmadr;
    private String phoneNumber;
    private Double latitude;
    private Double hardness;
}
