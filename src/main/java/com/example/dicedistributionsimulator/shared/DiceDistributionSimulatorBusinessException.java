package com.example.dicedistributionsimulator.shared;

import lombok.Getter;

import java.util.UUID;

@Getter
public class DiceDistributionSimulatorBusinessException extends RuntimeException {

    private final UUID tracingId;
    private final ValidationMessage validationMessage;

    public DiceDistributionSimulatorBusinessException(ValidationMessage validationMessage) {
        super();
        this.tracingId = UUID.randomUUID();
        this.validationMessage = validationMessage;
    }

    public DiceDistributionSimulatorBusinessException(ValidationMessage validationMessage, String message) {
        super(message);
        this.tracingId = UUID.randomUUID();
        this.validationMessage = validationMessage;
    }

    public DiceDistributionSimulatorBusinessException(ValidationMessage validationMessage, String message, Throwable cause) {
        super(message, cause);
        this.tracingId = UUID.randomUUID();
        this.validationMessage = validationMessage;
    }

    public DiceDistributionSimulatorBusinessException(ValidationMessage validationMessage, Throwable cause) {
        super(cause);
        this.tracingId = UUID.randomUUID();
        this.validationMessage = validationMessage;
    }

    protected DiceDistributionSimulatorBusinessException(ValidationMessage validationMessage, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.tracingId = UUID.randomUUID();
        this.validationMessage = validationMessage;
    }
}
