package com.richardxu.gof.mediator.example;

import com.richardxu.gof.mediator.example.Colleague;

public interface Mediator {
	void changed(Colleague colleague);
}
