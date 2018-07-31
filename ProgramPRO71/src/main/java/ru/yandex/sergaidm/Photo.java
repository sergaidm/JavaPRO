package ru.yandex.sergaidm;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "photos")
@Data
@NoArgsConstructor
public class Photo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private byte[] data;

	public Photo(byte[] data) {
		super();
		this.data = data;
	}

}
