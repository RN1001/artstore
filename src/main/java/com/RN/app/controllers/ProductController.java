package com.RN.app.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RN.app.Services.ProductService;
import com.RN.app.models.Art;
import com.RN.app.models.Artist;
import com.RN.app.repositories.ArtRepository;
import com.RN.app.repositories.ArtistRepository;
import com.RN.app.repositories.UserRepository;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	
	private UserRepository userRepository;
	private ArtistRepository artistRepository;
	private ArtRepository artRepository;
	private ProductService productService;
	
	@Autowired
	public ProductController(UserRepository userRepository, ArtistRepository artistRepository, ArtRepository artRepository, ProductService productService) {
		this.userRepository = userRepository;
		this.artistRepository = artistRepository;
		this.artRepository = artRepository;
		this.productService = productService;
		
	}
	
	@GetMapping(path = "/")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String index() {
		return "product/index";
	}
	
	@GetMapping(path = "/createArtist")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String create(Model model) {
		model.addAttribute("artist", new Artist());
		model.addAttribute("art", new Art());
		model.addAttribute("artists", this.productService.findAllArtists());
		return "product/createArtist";
	}
	
	@PostMapping(path = "/createArtist")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String ArtistCreated(@ModelAttribute @Valid Artist artist, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "product/createArtist";
		}
		
		
		this.productService.saveArtist(new Artist(artist.getFirstname(), artist.getLastname()));
		
		return "product/index";
	}
	
	@GetMapping(path = "/createArt")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String createNewArt(Model model) {
		model.addAttribute("art", new Art());
		//model.addAttribute("artist", this.artistsRepo.findAll());
		return "product/createArt";
	}
	
	@PostMapping(path = "/createArt")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String artCreated(@ModelAttribute @Valid Art art, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "product/createArtist";
		}
		
		this.productService.saveArt(new Art(art.getName(), art.getCost(), art.getArtistid()));		
		
		return "product/index";
	}
	
	@GetMapping(path = "/edit")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String edit(Model model) {
		
		return "product/edit";
	}
	
	@GetMapping(path = "/delete")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String delete() {
		return "product/delete";
	}
	
	
}
