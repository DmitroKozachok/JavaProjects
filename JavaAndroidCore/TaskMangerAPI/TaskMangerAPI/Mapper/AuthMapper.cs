using AutoMapper;
using TaskMangerAPI.Entities.Identity;
using TaskMangerAPI.Models.Auth;
using TaskMangerAPI.Models.Seeder;

namespace TaskMangerAPI.Mapper;

public class AuthMapper : Profile
{
    public AuthMapper()
    {
        CreateMap<RegisterModel, UserEntity>()
                .ForMember(x => x.UserName, opt => opt.MapFrom(x => x.Email));
        CreateMap<SeederUserModel, UserEntity>()
            .ForMember(x => x.UserName, opt => opt.MapFrom(x => x.Email));
    }
}
